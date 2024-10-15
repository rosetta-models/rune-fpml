package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Lien;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LienValidator implements Validator<Lien> {

	private List<ComparisonResult> getComparisonResults(Lien o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("lienScheme", (String) o.getLienScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Lien> validate(RosettaPath path, Lien o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Lien", ValidationType.CARDINALITY, "Lien", path, "", error);
		}
		return success("Lien", ValidationType.CARDINALITY, "Lien", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Lien o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Lien", ValidationType.CARDINALITY, "Lien", path, "", res.getError());
				}
				return success("Lien", ValidationType.CARDINALITY, "Lien", path, "");
			})
			.collect(toList());
	}

}
