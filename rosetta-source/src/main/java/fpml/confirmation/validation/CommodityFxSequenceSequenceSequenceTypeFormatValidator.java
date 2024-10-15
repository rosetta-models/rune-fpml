package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFxSequenceSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFxSequenceSequenceSequenceTypeFormatValidator implements Validator<CommodityFxSequenceSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityFxSequenceSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFxSequenceSequenceSequence> validate(RosettaPath path, CommodityFxSequenceSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFxSequenceSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequenceSequence", path, "", error);
		}
		return success("CommodityFxSequenceSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFxSequenceSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFxSequenceSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequenceSequence", path, "", res.getError());
				}
				return success("CommodityFxSequenceSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequenceSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
