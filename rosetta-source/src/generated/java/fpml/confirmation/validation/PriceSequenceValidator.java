package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.PriceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceSequenceValidator implements Validator<PriceSequence> {

	private List<ComparisonResult> getComparisonResults(PriceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityPriceModel", (EquityPriceModel) o.getEquityPriceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PriceSequence> validate(RosettaPath path, PriceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceSequence", ValidationType.CARDINALITY, "PriceSequence", path, "", error);
		}
		return success("PriceSequence", ValidationType.CARDINALITY, "PriceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceSequence", ValidationType.CARDINALITY, "PriceSequence", path, "", res.getError());
				}
				return success("PriceSequence", ValidationType.CARDINALITY, "PriceSequence", path, "");
			})
			.collect(toList());
	}

}
