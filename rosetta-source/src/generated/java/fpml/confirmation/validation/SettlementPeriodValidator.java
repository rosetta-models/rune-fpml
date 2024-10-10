package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodValidator implements Validator<SettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (Date) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriod> validate(RosettaPath path, SettlementPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriod", ValidationType.CARDINALITY, "SettlementPeriod", path, "", error);
		}
		return success("SettlementPeriod", ValidationType.CARDINALITY, "SettlementPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriod", ValidationType.CARDINALITY, "SettlementPeriod", path, "", res.getError());
				}
				return success("SettlementPeriod", ValidationType.CARDINALITY, "SettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
