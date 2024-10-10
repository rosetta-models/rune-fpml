package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NettedSwapBaseValidator implements Validator<NettedSwapBase> {

	private List<ComparisonResult> getComparisonResults(NettedSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NettedSwapBase> validate(RosettaPath path, NettedSwapBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NettedSwapBase", ValidationType.CARDINALITY, "NettedSwapBase", path, "", error);
		}
		return success("NettedSwapBase", ValidationType.CARDINALITY, "NettedSwapBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NettedSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NettedSwapBase", ValidationType.CARDINALITY, "NettedSwapBase", path, "", res.getError());
				}
				return success("NettedSwapBase", ValidationType.CARDINALITY, "NettedSwapBase", path, "");
			})
			.collect(toList());
	}

}
