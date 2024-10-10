package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityProductModelSequenceChoiceTypeFormatValidator implements Validator<CommodityProductModelSequenceChoice> {

	private List<ComparisonResult> getComparisonResults(CommodityProductModelSequenceChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityProductModelSequenceChoice> validate(RosettaPath path, CommodityProductModelSequenceChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityProductModelSequenceChoice", ValidationType.TYPE_FORMAT, "CommodityProductModelSequenceChoice", path, "", error);
		}
		return success("CommodityProductModelSequenceChoice", ValidationType.TYPE_FORMAT, "CommodityProductModelSequenceChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityProductModelSequenceChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityProductModelSequenceChoice", ValidationType.TYPE_FORMAT, "CommodityProductModelSequenceChoice", path, "", res.getError());
				}
				return success("CommodityProductModelSequenceChoice", ValidationType.TYPE_FORMAT, "CommodityProductModelSequenceChoice", path, "");
			})
			.collect(toList());
	}

}
