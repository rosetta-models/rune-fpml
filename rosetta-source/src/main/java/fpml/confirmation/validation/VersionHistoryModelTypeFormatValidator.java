package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VersionHistoryModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VersionHistoryModelTypeFormatValidator implements Validator<VersionHistoryModel> {

	private List<ComparisonResult> getComparisonResults(VersionHistoryModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("version", o.getVersion(), empty(), of(0), of(new BigDecimal("0")), empty())
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
			return failure("VersionHistoryModel", ValidationType.TYPE_FORMAT, "VersionHistoryModel", path, "", error);
		}
		return success("VersionHistoryModel", ValidationType.TYPE_FORMAT, "VersionHistoryModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionHistoryModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionHistoryModel", ValidationType.TYPE_FORMAT, "VersionHistoryModel", path, "", res.getError());
				}
				return success("VersionHistoryModel", ValidationType.TYPE_FORMAT, "VersionHistoryModel", path, "");
			})
			.collect(toList());
	}

}
