package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Market;
import fpml.confirmation.QuotedAssetSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MarketValidator implements Validator<Market> {

	private List<ComparisonResult> getComparisonResults(Market o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("benchmarkQuotes", (QuotedAssetSet) o.getBenchmarkQuotes() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Market> validate(RosettaPath path, Market o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Market", ValidationType.CARDINALITY, "Market", path, "", error);
		}
		return success("Market", ValidationType.CARDINALITY, "Market", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Market o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Market", ValidationType.CARDINALITY, "Market", path, "", res.getError());
				}
				return success("Market", ValidationType.CARDINALITY, "Market", path, "");
			})
			.collect(toList());
	}

}
