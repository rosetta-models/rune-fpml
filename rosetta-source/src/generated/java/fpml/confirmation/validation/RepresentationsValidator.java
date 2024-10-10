package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Representations;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepresentationsValidator implements Validator<Representations> {

	private List<ComparisonResult> getComparisonResults(Representations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonReliance", (Boolean) o.getNonReliance() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementsRegardingHedging", (Boolean) o.getAgreementsRegardingHedging() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexDisclaimer", (Boolean) o.getIndexDisclaimer() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalAcknowledgements", (Boolean) o.getAdditionalAcknowledgements() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Representations> validate(RosettaPath path, Representations o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Representations", ValidationType.CARDINALITY, "Representations", path, "", error);
		}
		return success("Representations", ValidationType.CARDINALITY, "Representations", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Representations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Representations", ValidationType.CARDINALITY, "Representations", path, "", res.getError());
				}
				return success("Representations", ValidationType.CARDINALITY, "Representations", path, "");
			})
			.collect(toList());
	}

}
