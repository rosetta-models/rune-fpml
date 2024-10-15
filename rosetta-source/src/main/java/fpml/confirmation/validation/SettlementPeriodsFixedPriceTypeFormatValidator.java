package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodsFixedPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsFixedPriceTypeFormatValidator implements Validator<SettlementPeriodsFixedPrice> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodsFixedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementPeriodsFixedPrice> validate(RosettaPath path, SettlementPeriodsFixedPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodsFixedPrice", ValidationType.TYPE_FORMAT, "SettlementPeriodsFixedPrice", path, "", error);
		}
		return success("SettlementPeriodsFixedPrice", ValidationType.TYPE_FORMAT, "SettlementPeriodsFixedPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsFixedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodsFixedPrice", ValidationType.TYPE_FORMAT, "SettlementPeriodsFixedPrice", path, "", res.getError());
				}
				return success("SettlementPeriodsFixedPrice", ValidationType.TYPE_FORMAT, "SettlementPeriodsFixedPrice", path, "");
			})
			.collect(toList());
	}

}
