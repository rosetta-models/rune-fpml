package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PriceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceModelTypeFormatValidator implements Validator<PriceModel> {

	private List<ComparisonResult> getComparisonResults(PriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PriceModel> validate(RosettaPath path, PriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceModel", ValidationType.TYPE_FORMAT, "PriceModel", path, "", error);
		}
		return success("PriceModel", ValidationType.TYPE_FORMAT, "PriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceModel", ValidationType.TYPE_FORMAT, "PriceModel", path, "", res.getError());
				}
				return success("PriceModel", ValidationType.TYPE_FORMAT, "PriceModel", path, "");
			})
			.collect(toList());
	}

}
