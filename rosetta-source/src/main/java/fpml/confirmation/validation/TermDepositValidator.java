package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.TermDeposit;
import fpml.confirmation.TermDepositFeatures;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TermDepositValidator implements Validator<TermDeposit> {

	private List<ComparisonResult> getComparisonResults(TermDeposit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("startDate", (Date) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("maturityDate", (Date) o.getMaturityDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxTenorModel", (FxTenorModel) o.getFxTenorModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("principal", (PositiveMoney) o.getPrincipal() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("features", (TermDepositFeatures) o.getFeatures() != null ? 1 : 0, 0, 1), 
				checkCardinality("interest", (Money) o.getInterest() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TermDeposit> validate(RosettaPath path, TermDeposit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermDeposit", ValidationType.CARDINALITY, "TermDeposit", path, "", error);
		}
		return success("TermDeposit", ValidationType.CARDINALITY, "TermDeposit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDeposit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermDeposit", ValidationType.CARDINALITY, "TermDeposit", path, "", res.getError());
				}
				return success("TermDeposit", ValidationType.CARDINALITY, "TermDeposit", path, "");
			})
			.collect(toList());
	}

}
