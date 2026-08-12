CREATE TABLE installations (
  id TEXT PRIMARY KEY,
  created_at TEXT NOT NULL,
  revoked_at TEXT
);

CREATE TABLE recovery_requests (
  request_id TEXT PRIMARY KEY,
  installation_id TEXT NOT NULL REFERENCES installations(id) ON DELETE CASCADE,
  idempotency_key TEXT NOT NULL,
  status TEXT NOT NULL CHECK (status IN ('accepted', 'complete', 'failed')),
  input_mode TEXT NOT NULL CHECK (input_mode IN ('text', 'audio')),
  created_at TEXT NOT NULL,
  completed_at TEXT,
  provider_model TEXT,
  output_hash TEXT,
  error_class TEXT,
  UNIQUE (installation_id, idempotency_key)
);

CREATE INDEX recovery_requests_allowance_idx
  ON recovery_requests (installation_id, status, created_at);

CREATE TABLE feature_flags (
  key TEXT PRIMARY KEY,
  value TEXT NOT NULL,
  updated_at TEXT NOT NULL
);

-- Cloud AI stays off until the account, privacy disclosure, and grounding spike
-- are complete. Seven is the already approved Run 9 launch hypothesis, not a
-- validated fairness result.
INSERT INTO feature_flags (key, value, updated_at)
VALUES
  ('cloud_enabled', 'false', '2026-08-12T00:00:00.000Z'),
  ('free_allowance', '7', '2026-08-12T00:00:00.000Z');
