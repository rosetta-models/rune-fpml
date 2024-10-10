package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountReference;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BuyerSellerModelValidator implements Validator<BuyerSellerModel> {

	private List<ComparisonResult> getComparisonResults(BuyerSellerModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BuyerSellerModel> validate(RosettaPath path, BuyerSellerModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BuyerSellerModel", ValidationType.CARDINALITY, "BuyerSellerModel", path, "", error);
		}
		return success("BuyerSellerModel", ValidationType.CARDINALITY, "BuyerSellerModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BuyerSellerModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BuyerSellerModel", ValidationType.CARDINALITY, "BuyerSellerModel", path, "", res.getError());
				}
				return success("BuyerSellerModel", ValidationType.CARDINALITY, "BuyerSellerModel", path, "");
			})
			.collect(toList());
	}

}
