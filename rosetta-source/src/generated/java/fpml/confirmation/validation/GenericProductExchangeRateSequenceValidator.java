package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProductExchangeRateSequence;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductExchangeRateSequenceValidator implements Validator<GenericProductExchangeRateSequence> {

	private List<ComparisonResult> getComparisonResults(GenericProductExchangeRateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("genericProductExchangeRateSequenceSequence", (GenericProductExchangeRateSequenceSequence) o.getGenericProductExchangeRateSequenceSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericProductExchangeRateSequence> validate(RosettaPath path, GenericProductExchangeRateSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProductExchangeRateSequence", ValidationType.CARDINALITY, "GenericProductExchangeRateSequence", path, "", error);
		}
		return success("GenericProductExchangeRateSequence", ValidationType.CARDINALITY, "GenericProductExchangeRateSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductExchangeRateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductExchangeRateSequence", ValidationType.CARDINALITY, "GenericProductExchangeRateSequence", path, "", res.getError());
				}
				return success("GenericProductExchangeRateSequence", ValidationType.CARDINALITY, "GenericProductExchangeRateSequence", path, "");
			})
			.collect(toList());
	}

}
