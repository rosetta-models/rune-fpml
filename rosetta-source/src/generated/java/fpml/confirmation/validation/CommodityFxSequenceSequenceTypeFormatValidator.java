package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFxSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFxSequenceSequenceTypeFormatValidator implements Validator<CommodityFxSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityFxSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFxSequenceSequence> validate(RosettaPath path, CommodityFxSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFxSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequence", path, "", error);
		}
		return success("CommodityFxSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFxSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFxSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequence", path, "", res.getError());
				}
				return success("CommodityFxSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
