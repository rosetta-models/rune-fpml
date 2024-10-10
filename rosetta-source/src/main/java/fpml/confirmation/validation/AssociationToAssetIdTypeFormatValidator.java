package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssociationToAssetId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AssociationToAssetIdTypeFormatValidator implements Validator<AssociationToAssetId> {

	private List<ComparisonResult> getComparisonResults(AssociationToAssetId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("associationToAssetIdScheme", o.getAssociationToAssetIdScheme(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<AssociationToAssetId> validate(RosettaPath path, AssociationToAssetId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AssociationToAssetId", ValidationType.TYPE_FORMAT, "AssociationToAssetId", path, "", error);
		}
		return success("AssociationToAssetId", ValidationType.TYPE_FORMAT, "AssociationToAssetId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssociationToAssetId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssociationToAssetId", ValidationType.TYPE_FORMAT, "AssociationToAssetId", path, "", res.getError());
				}
				return success("AssociationToAssetId", ValidationType.TYPE_FORMAT, "AssociationToAssetId", path, "");
			})
			.collect(toList());
	}

}
