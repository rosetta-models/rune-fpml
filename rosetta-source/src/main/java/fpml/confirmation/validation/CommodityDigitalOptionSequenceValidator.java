package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.CommodityNotionalQuantity;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalOptionSequenceValidator implements Validator<CommodityDigitalOptionSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalOptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalQuantity", (CommodityNotionalQuantity) o.getNotionalQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDigitalOptionSequence> validate(RosettaPath path, CommodityDigitalOptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDigitalOptionSequence", ValidationType.CARDINALITY, "CommodityDigitalOptionSequence", path, "", error);
		}
		return success("CommodityDigitalOptionSequence", ValidationType.CARDINALITY, "CommodityDigitalOptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalOptionSequence", ValidationType.CARDINALITY, "CommodityDigitalOptionSequence", path, "", res.getError());
				}
				return success("CommodityDigitalOptionSequence", ValidationType.CARDINALITY, "CommodityDigitalOptionSequence", path, "");
			})
			.collect(toList());
	}

}
