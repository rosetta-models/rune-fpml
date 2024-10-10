package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CouponType;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedIncomeSecurityContentModelValidator implements Validator<FixedIncomeSecurityContentModel> {

	private List<ComparisonResult> getComparisonResults(FixedIncomeSecurityContentModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerName", (String) o.getIssuerName() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerPartyReference", (PartyReference) o.getIssuerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponType", (CouponType) o.getCouponType() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponRate", (BigDecimal) o.getCouponRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturity", (Date) o.getMaturity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, FixedIncomeSecurityContentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedIncomeSecurityContentModel", ValidationType.CARDINALITY, "FixedIncomeSecurityContentModel", path, "", error);
		}
		return success("FixedIncomeSecurityContentModel", ValidationType.CARDINALITY, "FixedIncomeSecurityContentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedIncomeSecurityContentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedIncomeSecurityContentModel", ValidationType.CARDINALITY, "FixedIncomeSecurityContentModel", path, "", res.getError());
				}
				return success("FixedIncomeSecurityContentModel", ValidationType.CARDINALITY, "FixedIncomeSecurityContentModel", path, "");
			})
			.collect(toList());
	}

}
