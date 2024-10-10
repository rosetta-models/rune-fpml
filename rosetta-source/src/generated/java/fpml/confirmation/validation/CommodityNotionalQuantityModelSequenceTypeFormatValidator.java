package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityNotionalQuantityModelSequenceTypeFormatValidator implements Validator<CommodityNotionalQuantityModelSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityNotionalQuantityModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityNotionalQuantityModelSequence> validate(RosettaPath path, CommodityNotionalQuantityModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityNotionalQuantityModelSequence", ValidationType.TYPE_FORMAT, "CommodityNotionalQuantityModelSequence", path, "", error);
		}
		return success("CommodityNotionalQuantityModelSequence", ValidationType.TYPE_FORMAT, "CommodityNotionalQuantityModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalQuantityModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityNotionalQuantityModelSequence", ValidationType.TYPE_FORMAT, "CommodityNotionalQuantityModelSequence", path, "", res.getError());
				}
				return success("CommodityNotionalQuantityModelSequence", ValidationType.TYPE_FORMAT, "CommodityNotionalQuantityModelSequence", path, "");
			})
			.collect(toList());
	}

}
