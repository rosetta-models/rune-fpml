package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityOptionFeaturesModelSequenceTypeFormatValidator implements Validator<CommodityOptionFeaturesModelSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityOptionFeaturesModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityOptionFeaturesModelSequence> validate(RosettaPath path, CommodityOptionFeaturesModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityOptionFeaturesModelSequence", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModelSequence", path, "", error);
		}
		return success("CommodityOptionFeaturesModelSequence", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOptionFeaturesModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOptionFeaturesModelSequence", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModelSequence", path, "", res.getError());
				}
				return success("CommodityOptionFeaturesModelSequence", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModelSequence", path, "");
			})
			.collect(toList());
	}

}
