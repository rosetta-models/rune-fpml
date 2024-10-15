package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LcIssuance;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LcIssuanceTypeFormatValidator implements Validator<LcIssuance> {

	private List<ComparisonResult> getComparisonResults(LcIssuance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LcIssuance> validate(RosettaPath path, LcIssuance o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LcIssuance", ValidationType.TYPE_FORMAT, "LcIssuance", path, "", error);
		}
		return success("LcIssuance", ValidationType.TYPE_FORMAT, "LcIssuance", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcIssuance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LcIssuance", ValidationType.TYPE_FORMAT, "LcIssuance", path, "", res.getError());
				}
				return success("LcIssuance", ValidationType.TYPE_FORMAT, "LcIssuance", path, "");
			})
			.collect(toList());
	}

}
