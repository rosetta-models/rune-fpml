package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationSetDetail;
import fpml.confirmation.validation.ValuationSetDetailTypeFormatValidator;
import fpml.confirmation.validation.ValuationSetDetailValidator;
import fpml.confirmation.validation.exists.ValuationSetDetailOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationSetDetail.class)
public class ValuationSetDetailMeta implements RosettaMetaData<ValuationSetDetail> {

	@Override
	public List<Validator<? super ValuationSetDetail>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationSetDetail, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationSetDetail> validator() {
		return new ValuationSetDetailValidator();
	}

	@Override
	public Validator<? super ValuationSetDetail> typeFormatValidator() {
		return new ValuationSetDetailTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationSetDetail, Set<String>> onlyExistsValidator() {
		return new ValuationSetDetailOnlyExistsValidator();
	}
}
