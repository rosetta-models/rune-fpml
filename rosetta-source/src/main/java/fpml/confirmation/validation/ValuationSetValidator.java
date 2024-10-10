package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ValuationSet;
import fpml.confirmation.ValuationSetDetail;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationSetValidator implements Validator<ValuationSet> {

	private List<ComparisonResult> getComparisonResults(ValuationSet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("baseParty", (PartyReference) o.getBaseParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("detail", (ValuationSetDetail) o.getDetail() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ValuationSet> validate(RosettaPath path, ValuationSet o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationSet", ValidationType.CARDINALITY, "ValuationSet", path, "", error);
		}
		return success("ValuationSet", ValidationType.CARDINALITY, "ValuationSet", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationSet", ValidationType.CARDINALITY, "ValuationSet", path, "", res.getError());
				}
				return success("ValuationSet", ValidationType.CARDINALITY, "ValuationSet", path, "");
			})
			.collect(toList());
	}

}
