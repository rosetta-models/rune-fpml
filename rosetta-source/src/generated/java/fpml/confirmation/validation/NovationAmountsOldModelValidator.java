package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NovationAmountsOldModel;
import fpml.confirmation.NovationAmountsOldModelSequence0;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import fpml.confirmation.NovationAmountsOldModelSequence2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationAmountsOldModelValidator implements Validator<NovationAmountsOldModel> {

	private List<ComparisonResult> getComparisonResults(NovationAmountsOldModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("novationAmountsOldModelSequence0", (NovationAmountsOldModelSequence0) o.getNovationAmountsOldModelSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("novationAmountsOldModelSequence1", (NovationAmountsOldModelSequence1) o.getNovationAmountsOldModelSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("novationAmountsOldModelSequence2", (NovationAmountsOldModelSequence2) o.getNovationAmountsOldModelSequence2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, NovationAmountsOldModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationAmountsOldModel", ValidationType.CARDINALITY, "NovationAmountsOldModel", path, "", error);
		}
		return success("NovationAmountsOldModel", ValidationType.CARDINALITY, "NovationAmountsOldModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationAmountsOldModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationAmountsOldModel", ValidationType.CARDINALITY, "NovationAmountsOldModel", path, "", res.getError());
				}
				return success("NovationAmountsOldModel", ValidationType.CARDINALITY, "NovationAmountsOldModel", path, "");
			})
			.collect(toList());
	}

}
