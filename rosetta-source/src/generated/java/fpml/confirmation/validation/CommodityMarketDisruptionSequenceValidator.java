package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.MarketDisruptionEventsEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMarketDisruptionSequenceValidator implements Validator<CommodityMarketDisruptionSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityMarketDisruptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("marketDisruptionEvents", (MarketDisruptionEventsEnum) o.getMarketDisruptionEvents() != null ? 1 : 0, 1, 1)
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
			return failure("CommodityMarketDisruptionSequence", ValidationType.CARDINALITY, "CommodityMarketDisruptionSequence", path, "", error);
		}
		return success("CommodityMarketDisruptionSequence", ValidationType.CARDINALITY, "CommodityMarketDisruptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMarketDisruptionSequence", ValidationType.CARDINALITY, "CommodityMarketDisruptionSequence", path, "", res.getError());
				}
				return success("CommodityMarketDisruptionSequence", ValidationType.CARDINALITY, "CommodityMarketDisruptionSequence", path, "");
			})
			.collect(toList());
	}

}
