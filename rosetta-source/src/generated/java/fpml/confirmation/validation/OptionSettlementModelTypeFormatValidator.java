package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionSettlementModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionSettlementModelTypeFormatValidator implements Validator<OptionSettlementModel> {

	private List<ComparisonResult> getComparisonResults(OptionSettlementModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionSettlementModel> validate(RosettaPath path, OptionSettlementModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionSettlementModel", ValidationType.TYPE_FORMAT, "OptionSettlementModel", path, "", error);
		}
		return success("OptionSettlementModel", ValidationType.TYPE_FORMAT, "OptionSettlementModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionSettlementModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionSettlementModel", ValidationType.TYPE_FORMAT, "OptionSettlementModel", path, "", res.getError());
				}
				return success("OptionSettlementModel", ValidationType.TYPE_FORMAT, "OptionSettlementModel", path, "");
			})
			.collect(toList());
	}

}
