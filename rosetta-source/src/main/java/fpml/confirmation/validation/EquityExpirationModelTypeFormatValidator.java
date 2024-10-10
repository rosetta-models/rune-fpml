package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityExpirationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExpirationModelTypeFormatValidator implements Validator<EquityExpirationModel> {

	private List<ComparisonResult> getComparisonResults(EquityExpirationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityExpirationModel> validate(RosettaPath path, EquityExpirationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExpirationModel", ValidationType.TYPE_FORMAT, "EquityExpirationModel", path, "", error);
		}
		return success("EquityExpirationModel", ValidationType.TYPE_FORMAT, "EquityExpirationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExpirationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExpirationModel", ValidationType.TYPE_FORMAT, "EquityExpirationModel", path, "", res.getError());
				}
				return success("EquityExpirationModel", ValidationType.TYPE_FORMAT, "EquityExpirationModel", path, "");
			})
			.collect(toList());
	}

}
