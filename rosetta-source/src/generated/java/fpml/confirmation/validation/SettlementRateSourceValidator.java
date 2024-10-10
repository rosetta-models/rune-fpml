package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.InformationSource;
import fpml.confirmation.SettlementRateSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementRateSourceValidator implements Validator<SettlementRateSource> {

	private List<ComparisonResult> getComparisonResults(SettlementRateSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementReferenceBanks", (CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementRateSource> validate(RosettaPath path, SettlementRateSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementRateSource", ValidationType.CARDINALITY, "SettlementRateSource", path, "", error);
		}
		return success("SettlementRateSource", ValidationType.CARDINALITY, "SettlementRateSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementRateSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementRateSource", ValidationType.CARDINALITY, "SettlementRateSource", path, "", res.getError());
				}
				return success("SettlementRateSource", ValidationType.CARDINALITY, "SettlementRateSource", path, "");
			})
			.collect(toList());
	}

}
