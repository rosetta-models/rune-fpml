package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDigitalOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalOptionTypeFormatValidator implements Validator<CommodityDigitalOption> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityDigitalOption> validate(RosettaPath path, CommodityDigitalOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDigitalOption", ValidationType.TYPE_FORMAT, "CommodityDigitalOption", path, "", error);
		}
		return success("CommodityDigitalOption", ValidationType.TYPE_FORMAT, "CommodityDigitalOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalOption", ValidationType.TYPE_FORMAT, "CommodityDigitalOption", path, "", res.getError());
				}
				return success("CommodityDigitalOption", ValidationType.TYPE_FORMAT, "CommodityDigitalOption", path, "");
			})
			.collect(toList());
	}

}
