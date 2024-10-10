package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragePriceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AveragePriceLegTypeFormatValidator implements Validator<AveragePriceLeg> {

	private List<ComparisonResult> getComparisonResults(AveragePriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AveragePriceLeg> validate(RosettaPath path, AveragePriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AveragePriceLeg", ValidationType.TYPE_FORMAT, "AveragePriceLeg", path, "", error);
		}
		return success("AveragePriceLeg", ValidationType.TYPE_FORMAT, "AveragePriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragePriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragePriceLeg", ValidationType.TYPE_FORMAT, "AveragePriceLeg", path, "", res.getError());
				}
				return success("AveragePriceLeg", ValidationType.TYPE_FORMAT, "AveragePriceLeg", path, "");
			})
			.collect(toList());
	}

}
