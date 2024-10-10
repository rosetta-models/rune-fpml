package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityNotionalAmountReferenceTypeFormatValidator implements Validator<CommodityNotionalAmountReference> {

	private List<ComparisonResult> getComparisonResults(CommodityNotionalAmountReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityNotionalAmountReference> validate(RosettaPath path, CommodityNotionalAmountReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityNotionalAmountReference", ValidationType.TYPE_FORMAT, "CommodityNotionalAmountReference", path, "", error);
		}
		return success("CommodityNotionalAmountReference", ValidationType.TYPE_FORMAT, "CommodityNotionalAmountReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalAmountReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityNotionalAmountReference", ValidationType.TYPE_FORMAT, "CommodityNotionalAmountReference", path, "", res.getError());
				}
				return success("CommodityNotionalAmountReference", ValidationType.TYPE_FORMAT, "CommodityNotionalAmountReference", path, "");
			})
			.collect(toList());
	}

}
