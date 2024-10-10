package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMarketDisruptionSequenceTypeFormatValidator implements Validator<CommodityMarketDisruptionSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityMarketDisruptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityMarketDisruptionSequence> validate(RosettaPath path, CommodityMarketDisruptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMarketDisruptionSequence", ValidationType.TYPE_FORMAT, "CommodityMarketDisruptionSequence", path, "", error);
		}
		return success("CommodityMarketDisruptionSequence", ValidationType.TYPE_FORMAT, "CommodityMarketDisruptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMarketDisruptionSequence", ValidationType.TYPE_FORMAT, "CommodityMarketDisruptionSequence", path, "", res.getError());
				}
				return success("CommodityMarketDisruptionSequence", ValidationType.TYPE_FORMAT, "CommodityMarketDisruptionSequence", path, "");
			})
			.collect(toList());
	}

}
