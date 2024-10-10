package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Lag;
import fpml.confirmation.LagOrReferenceModel;
import fpml.confirmation.LagReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LagOrReferenceModelValidator implements Validator<LagOrReferenceModel> {

	private List<ComparisonResult> getComparisonResults(LagOrReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lag", (Lag) o.getLag() != null ? 1 : 0, 0, 1), 
				checkCardinality("lagReference", (LagReference) o.getLagReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LagOrReferenceModel> validate(RosettaPath path, LagOrReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LagOrReferenceModel", ValidationType.CARDINALITY, "LagOrReferenceModel", path, "", error);
		}
		return success("LagOrReferenceModel", ValidationType.CARDINALITY, "LagOrReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LagOrReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LagOrReferenceModel", ValidationType.CARDINALITY, "LagOrReferenceModel", path, "", res.getError());
				}
				return success("LagOrReferenceModel", ValidationType.CARDINALITY, "LagOrReferenceModel", path, "");
			})
			.collect(toList());
	}

}
