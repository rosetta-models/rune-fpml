package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.VersionHistoryModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VersionHistoryModelValidator implements Validator<VersionHistoryModel> {

	private List<ComparisonResult> getComparisonResults(VersionHistoryModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("version", (Integer) o.getVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (IdentifiedDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VersionHistoryModel> validate(RosettaPath path, VersionHistoryModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VersionHistoryModel", ValidationType.CARDINALITY, "VersionHistoryModel", path, "", error);
		}
		return success("VersionHistoryModel", ValidationType.CARDINALITY, "VersionHistoryModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionHistoryModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionHistoryModel", ValidationType.CARDINALITY, "VersionHistoryModel", path, "", res.getError());
				}
				return success("VersionHistoryModel", ValidationType.CARDINALITY, "VersionHistoryModel", path, "");
			})
			.collect(toList());
	}

}
