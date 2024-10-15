package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdmissionToTrading;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.ProductSummary;
import fpml.confirmation.SettlementTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProductSummaryValidator implements Validator<ProductSummary> {

	private List<ComparisonResult> getComparisonResults(ProductSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("finalSettlementDate", (Date) o.getFinalSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("admissionToTrading", (AdmissionToTrading) o.getAdmissionToTrading() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ProductSummary> validate(RosettaPath path, ProductSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProductSummary", ValidationType.CARDINALITY, "ProductSummary", path, "", error);
		}
		return success("ProductSummary", ValidationType.CARDINALITY, "ProductSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductSummary", ValidationType.CARDINALITY, "ProductSummary", path, "", res.getError());
				}
				return success("ProductSummary", ValidationType.CARDINALITY, "ProductSummary", path, "");
			})
			.collect(toList());
	}

}
