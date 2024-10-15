package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.GenericEquityAttributesModel;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.GenericProduct;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductValidator implements Validator<GenericProduct> {

	private List<ComparisonResult> getComparisonResults(GenericProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiLeg", (Boolean) o.getMultiLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterpartyReference", (List<? extends PartyReference>) o.getCounterpartyReference() == null ? 0 : ((List<? extends PartyReference>) o.getCounterpartyReference()).size(), 0, 2), 
				checkCardinality("premium", (SimplePayment) o.getPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableDate2) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDate", (AdjustableDate2) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableDate2) o.getTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("genericCommodityAttributesModel", (GenericCommodityAttributesModel) o.getGenericCommodityAttributesModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("genericEquityAttributesModel", (GenericEquityAttributesModel) o.getGenericEquityAttributesModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("genericOptionAttributesModel", (GenericOptionAttributesModel) o.getGenericOptionAttributesModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericProduct> validate(RosettaPath path, GenericProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProduct", ValidationType.CARDINALITY, "GenericProduct", path, "", error);
		}
		return success("GenericProduct", ValidationType.CARDINALITY, "GenericProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProduct", ValidationType.CARDINALITY, "GenericProduct", path, "", res.getError());
				}
				return success("GenericProduct", ValidationType.CARDINALITY, "GenericProduct", path, "");
			})
			.collect(toList());
	}

}
