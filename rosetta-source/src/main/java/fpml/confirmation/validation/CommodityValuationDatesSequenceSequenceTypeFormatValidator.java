package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityValuationDatesSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityValuationDatesSequenceSequenceTypeFormatValidator implements Validator<CommodityValuationDatesSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityValuationDatesSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityValuationDatesSequenceSequence> validate(RosettaPath path, CommodityValuationDatesSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityValuationDatesSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityValuationDatesSequenceSequence", path, "", error);
		}
		return success("CommodityValuationDatesSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityValuationDatesSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDatesSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityValuationDatesSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityValuationDatesSequenceSequence", path, "", res.getError());
				}
				return success("CommodityValuationDatesSequenceSequence", ValidationType.TYPE_FORMAT, "CommodityValuationDatesSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
