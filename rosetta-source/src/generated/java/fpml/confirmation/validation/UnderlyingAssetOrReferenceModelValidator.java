package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.AssetReference;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyingAssetOrReferenceModelValidator implements Validator<UnderlyingAssetOrReferenceModel> {

	private List<ComparisonResult> getComparisonResults(UnderlyingAssetOrReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetReference", (AssetReference) o.getUnderlyingAssetReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<UnderlyingAssetOrReferenceModel> validate(RosettaPath path, UnderlyingAssetOrReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnderlyingAssetOrReferenceModel", ValidationType.CARDINALITY, "UnderlyingAssetOrReferenceModel", path, "", error);
		}
		return success("UnderlyingAssetOrReferenceModel", ValidationType.CARDINALITY, "UnderlyingAssetOrReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyingAssetOrReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyingAssetOrReferenceModel", ValidationType.CARDINALITY, "UnderlyingAssetOrReferenceModel", path, "", res.getError());
				}
				return success("UnderlyingAssetOrReferenceModel", ValidationType.CARDINALITY, "UnderlyingAssetOrReferenceModel", path, "");
			})
			.collect(toList());
	}

}
