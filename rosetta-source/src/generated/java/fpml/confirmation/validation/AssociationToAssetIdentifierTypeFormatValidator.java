package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssociationToAssetIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AssociationToAssetIdentifierTypeFormatValidator implements Validator<AssociationToAssetIdentifier> {

	private List<ComparisonResult> getComparisonResults(AssociationToAssetIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AssociationToAssetIdentifier> validate(RosettaPath path, AssociationToAssetIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AssociationToAssetIdentifier", ValidationType.TYPE_FORMAT, "AssociationToAssetIdentifier", path, "", error);
		}
		return success("AssociationToAssetIdentifier", ValidationType.TYPE_FORMAT, "AssociationToAssetIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssociationToAssetIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssociationToAssetIdentifier", ValidationType.TYPE_FORMAT, "AssociationToAssetIdentifier", path, "", res.getError());
				}
				return success("AssociationToAssetIdentifier", ValidationType.TYPE_FORMAT, "AssociationToAssetIdentifier", path, "");
			})
			.collect(toList());
	}

}
