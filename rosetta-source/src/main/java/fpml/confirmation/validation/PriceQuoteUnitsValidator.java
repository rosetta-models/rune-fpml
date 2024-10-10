package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PriceQuoteUnits;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceQuoteUnitsValidator implements Validator<PriceQuoteUnits> {

	private List<ComparisonResult> getComparisonResults(PriceQuoteUnits o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceQuoteUnitsScheme", (String) o.getPriceQuoteUnitsScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PriceQuoteUnits> validate(RosettaPath path, PriceQuoteUnits o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceQuoteUnits", ValidationType.CARDINALITY, "PriceQuoteUnits", path, "", error);
		}
		return success("PriceQuoteUnits", ValidationType.CARDINALITY, "PriceQuoteUnits", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceQuoteUnits o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceQuoteUnits", ValidationType.CARDINALITY, "PriceQuoteUnits", path, "", res.getError());
				}
				return success("PriceQuoteUnits", ValidationType.CARDINALITY, "PriceQuoteUnits", path, "");
			})
			.collect(toList());
	}

}
