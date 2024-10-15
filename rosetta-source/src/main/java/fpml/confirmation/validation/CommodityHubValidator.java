package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityHub;
import fpml.confirmation.CommodityHubCode;
import fpml.confirmation.PartyAndAccountReferencesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityHubValidator implements Validator<CommodityHub> {

	private List<ComparisonResult> getComparisonResults(CommodityHub o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("hubCode", (CommodityHubCode) o.getHubCode() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityHub> validate(RosettaPath path, CommodityHub o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityHub", ValidationType.CARDINALITY, "CommodityHub", path, "", error);
		}
		return success("CommodityHub", ValidationType.CARDINALITY, "CommodityHub", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityHub o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityHub", ValidationType.CARDINALITY, "CommodityHub", path, "", res.getError());
				}
				return success("CommodityHub", ValidationType.CARDINALITY, "CommodityHub", path, "");
			})
			.collect(toList());
	}

}
