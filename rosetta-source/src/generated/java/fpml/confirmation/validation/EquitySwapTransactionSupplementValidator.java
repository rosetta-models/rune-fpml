package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.EquitySwapTransactionSupplement;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquitySwapTransactionSupplementValidator implements Validator<EquitySwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(EquitySwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("returnSwapLeg", (List<? extends DirectionalLeg>) o.getReturnSwapLeg() == null ? 0 : ((List<? extends DirectionalLeg>) o.getReturnSwapLeg()).size(), 1, 0), 
				checkCardinality("principalExchangeFeatures", (PrincipalExchangeFeatures) o.getPrincipalExchangeFeatures() != null ? 1 : 0, 0, 1), 
				checkCardinality("mutualOrOptionalEarlyTerminationModel", (MutualOrOptionalEarlyTerminationModel) o.getMutualOrOptionalEarlyTerminationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityUnderlyerProvisionsModel", (EquityUnderlyerProvisionsModel) o.getEquityUnderlyerProvisionsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquitySwapTransactionSupplement> validate(RosettaPath path, EquitySwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquitySwapTransactionSupplement", ValidationType.CARDINALITY, "EquitySwapTransactionSupplement", path, "", error);
		}
		return success("EquitySwapTransactionSupplement", ValidationType.CARDINALITY, "EquitySwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquitySwapTransactionSupplement", ValidationType.CARDINALITY, "EquitySwapTransactionSupplement", path, "", res.getError());
				}
				return success("EquitySwapTransactionSupplement", ValidationType.CARDINALITY, "EquitySwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
