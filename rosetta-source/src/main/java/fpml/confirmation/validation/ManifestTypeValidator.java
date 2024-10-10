package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ManifestType;
import fpml.confirmation.ReferenceType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ManifestTypeValidator implements Validator<ManifestType> {

	private List<ComparisonResult> getComparisonResults(ManifestType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reference", (List<? extends ReferenceType>) o.getReference() == null ? 0 : ((List<? extends ReferenceType>) o.getReference()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ManifestType> validate(RosettaPath path, ManifestType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ManifestType", ValidationType.CARDINALITY, "ManifestType", path, "", error);
		}
		return success("ManifestType", ValidationType.CARDINALITY, "ManifestType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ManifestType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ManifestType", ValidationType.CARDINALITY, "ManifestType", path, "", res.getError());
				}
				return success("ManifestType", ValidationType.CARDINALITY, "ManifestType", path, "");
			})
			.collect(toList());
	}

}
