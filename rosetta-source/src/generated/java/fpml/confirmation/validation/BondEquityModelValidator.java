package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.EquityAsset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BondEquityModelValidator implements Validator<BondEquityModel> {

	private List<ComparisonResult> getComparisonResults(BondEquityModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("bondChoiceModel", (BondChoiceModel) o.getBondChoiceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("equity", (EquityAsset) o.getEquity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BondEquityModel> validate(RosettaPath path, BondEquityModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BondEquityModel", ValidationType.CARDINALITY, "BondEquityModel", path, "", error);
		}
		return success("BondEquityModel", ValidationType.CARDINALITY, "BondEquityModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondEquityModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BondEquityModel", ValidationType.CARDINALITY, "BondEquityModel", path, "", res.getError());
				}
				return success("BondEquityModel", ValidationType.CARDINALITY, "BondEquityModel", path, "");
			})
			.collect(toList());
	}

}
