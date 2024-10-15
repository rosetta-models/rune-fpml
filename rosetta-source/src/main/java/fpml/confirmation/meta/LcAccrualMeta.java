package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcAccrual;
import fpml.confirmation.validation.LcAccrualTypeFormatValidator;
import fpml.confirmation.validation.LcAccrualValidator;
import fpml.confirmation.validation.exists.LcAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcAccrual.class)
public class LcAccrualMeta implements RosettaMetaData<LcAccrual> {

	@Override
	public List<Validator<? super LcAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcAccrual> validator() {
		return new LcAccrualValidator();
	}

	@Override
	public Validator<? super LcAccrual> typeFormatValidator() {
		return new LcAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcAccrual, Set<String>> onlyExistsValidator() {
		return new LcAccrualOnlyExistsValidator();
	}
}
