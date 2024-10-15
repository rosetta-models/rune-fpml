package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LegId;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.VersionHistoryModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LegIdentifierValidator implements Validator<LegIdentifier> {

	private List<ComparisonResult> getComparisonResults(LegIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("legId", (LegId) o.getLegId() != null ? 1 : 0, 1, 1), 
				checkCardinality("versionHistoryModel", (VersionHistoryModel) o.getVersionHistoryModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LegIdentifier> validate(RosettaPath path, LegIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LegIdentifier", ValidationType.CARDINALITY, "LegIdentifier", path, "", error);
		}
		return success("LegIdentifier", ValidationType.CARDINALITY, "LegIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegIdentifier", ValidationType.CARDINALITY, "LegIdentifier", path, "", res.getError());
				}
				return success("LegIdentifier", ValidationType.CARDINALITY, "LegIdentifier", path, "");
			})
			.collect(toList());
	}

}
