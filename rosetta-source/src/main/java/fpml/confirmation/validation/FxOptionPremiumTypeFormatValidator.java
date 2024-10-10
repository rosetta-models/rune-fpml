package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxOptionPremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxOptionPremiumTypeFormatValidator implements Validator<FxOptionPremium> {

	private List<ComparisonResult> getComparisonResults(FxOptionPremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxOptionPremium> validate(RosettaPath path, FxOptionPremium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxOptionPremium", ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "", error);
		}
		return success("FxOptionPremium", ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOptionPremium", ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "", res.getError());
				}
				return success("FxOptionPremium", ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "");
			})
			.collect(toList());
	}

}
