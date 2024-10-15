package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UnderlyingAssetType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyingAssetTypeTypeFormatValidator implements Validator<UnderlyingAssetType> {

	private List<ComparisonResult> getComparisonResults(UnderlyingAssetType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<UnderlyingAssetType> validate(RosettaPath path, UnderlyingAssetType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnderlyingAssetType", ValidationType.TYPE_FORMAT, "UnderlyingAssetType", path, "", error);
		}
		return success("UnderlyingAssetType", ValidationType.TYPE_FORMAT, "UnderlyingAssetType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyingAssetType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyingAssetType", ValidationType.TYPE_FORMAT, "UnderlyingAssetType", path, "", res.getError());
				}
				return success("UnderlyingAssetType", ValidationType.TYPE_FORMAT, "UnderlyingAssetType", path, "");
			})
			.collect(toList());
	}

}
