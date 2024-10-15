package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.OptionBase;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionBaseValidator implements Validator<OptionBase> {

	private List<ComparisonResult> getComparisonResults(OptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OptionBase> validate(RosettaPath path, OptionBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionBase", ValidationType.CARDINALITY, "OptionBase", path, "", error);
		}
		return success("OptionBase", ValidationType.CARDINALITY, "OptionBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBase", ValidationType.CARDINALITY, "OptionBase", path, "", res.getError());
				}
				return success("OptionBase", ValidationType.CARDINALITY, "OptionBase", path, "");
			})
			.collect(toList());
	}

}
