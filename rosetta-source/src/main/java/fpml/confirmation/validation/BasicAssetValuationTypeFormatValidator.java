package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasicAssetValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasicAssetValuationTypeFormatValidator implements Validator<BasicAssetValuation> {

	private List<ComparisonResult> getComparisonResults(BasicAssetValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BasicAssetValuation> validate(RosettaPath path, BasicAssetValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasicAssetValuation", ValidationType.TYPE_FORMAT, "BasicAssetValuation", path, "", error);
		}
		return success("BasicAssetValuation", ValidationType.TYPE_FORMAT, "BasicAssetValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicAssetValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasicAssetValuation", ValidationType.TYPE_FORMAT, "BasicAssetValuation", path, "", res.getError());
				}
				return success("BasicAssetValuation", ValidationType.TYPE_FORMAT, "BasicAssetValuation", path, "");
			})
			.collect(toList());
	}

}
