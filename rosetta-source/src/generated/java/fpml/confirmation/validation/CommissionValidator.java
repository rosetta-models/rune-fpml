package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Commission;
import fpml.confirmation.CommissionDenominationEnum;
import fpml.confirmation.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommissionValidator implements Validator<Commission> {

	private List<ComparisonResult> getComparisonResults(Commission o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commissionDenomination", (CommissionDenominationEnum) o.getCommissionDenomination() != null ? 1 : 0, 1, 1), 
				checkCardinality("commissionAmount", (BigDecimal) o.getCommissionAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("commissionPerTrade", (BigDecimal) o.getCommissionPerTrade() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Commission> validate(RosettaPath path, Commission o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Commission", ValidationType.CARDINALITY, "Commission", path, "", error);
		}
		return success("Commission", ValidationType.CARDINALITY, "Commission", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Commission o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Commission", ValidationType.CARDINALITY, "Commission", path, "", res.getError());
				}
				return success("Commission", ValidationType.CARDINALITY, "Commission", path, "");
			})
			.collect(toList());
	}

}
