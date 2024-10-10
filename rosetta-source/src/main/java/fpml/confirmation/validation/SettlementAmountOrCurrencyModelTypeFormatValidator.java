package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementAmountOrCurrencyModelTypeFormatValidator implements Validator<SettlementAmountOrCurrencyModel> {

	private List<ComparisonResult> getComparisonResults(SettlementAmountOrCurrencyModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementAmountOrCurrencyModel> validate(RosettaPath path, SettlementAmountOrCurrencyModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementAmountOrCurrencyModel", ValidationType.TYPE_FORMAT, "SettlementAmountOrCurrencyModel", path, "", error);
		}
		return success("SettlementAmountOrCurrencyModel", ValidationType.TYPE_FORMAT, "SettlementAmountOrCurrencyModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementAmountOrCurrencyModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementAmountOrCurrencyModel", ValidationType.TYPE_FORMAT, "SettlementAmountOrCurrencyModel", path, "", res.getError());
				}
				return success("SettlementAmountOrCurrencyModel", ValidationType.TYPE_FORMAT, "SettlementAmountOrCurrencyModel", path, "");
			})
			.collect(toList());
	}

}
