package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApplicableAssets;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApplicableAssetsValidator implements Validator<ApplicableAssets> {

	private List<ComparisonResult> getComparisonResults(ApplicableAssets o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ApplicableAssets> validate(RosettaPath path, ApplicableAssets o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ApplicableAssets", ValidationType.CARDINALITY, "ApplicableAssets", path, "", error);
		}
		return success("ApplicableAssets", ValidationType.CARDINALITY, "ApplicableAssets", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableAssets o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableAssets", ValidationType.CARDINALITY, "ApplicableAssets", path, "", res.getError());
				}
				return success("ApplicableAssets", ValidationType.CARDINALITY, "ApplicableAssets", path, "");
			})
			.collect(toList());
	}

}
